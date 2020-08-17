package com.dinesh.newboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.newboot.config.JwtTokenUtil;
import com.dinesh.newboot.model.Order;
import com.dinesh.newboot.model.OrderDTO;
import com.dinesh.newboot.model.OrderList;
import com.dinesh.newboot.model.OrderListDTO;
import com.dinesh.newboot.model.User;
import com.dinesh.newboot.service.OrderListService;
import com.dinesh.newboot.service.OrderService;
import com.dinesh.newboot.service.UserService;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderContoller {
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderListService orderListService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<OrderListDTO>> getAllUser() {
		List<OrderList> orderLists = orderListService.findAll();
		Map<Integer, OrderListDTO> finalOrderList = new HashMap<Integer, OrderListDTO>();
		Map<String, Object> orderDetail;
		for (OrderList orderList : orderLists) {
			Integer orderId = orderList.getOrderId().getId();
			if (finalOrderList.containsKey(orderId) == false)
				finalOrderList.put(orderId, new OrderListDTO(orderId, orderList.getOrderId().getUserId().getName(),
						orderList.getOrderId().isHasPaid(), 0, new ArrayList<>()));

			float grandTotal = finalOrderList.get(orderId).getGrandTotal()
					+ (orderList.getQuantity() * orderList.getRate());
			orderDetail = new HashMap<String, Object>();
			orderDetail.put("itemname", orderList.getItemName());
			orderDetail.put("quantity", orderList.getQuantity());
			orderDetail.put("rate", orderList.getRate());
			finalOrderList.get(orderId).setGrandTotal(grandTotal);
			finalOrderList.get(orderId).getOrderList().add(orderDetail);
		}

		return ResponseEntity.ok(new ArrayList<>(finalOrderList.values()));
	}

	@RequestMapping(value = "/markPaid/{id}", method = RequestMethod.GET)
	public boolean markPaid(HttpServletRequest request, @PathVariable("id") int id) {
		Order order = orderService.findById(id);
		order.setHasPaid(true);
		orderService.save(order);
		return true;
	}

	@RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
	public boolean placeOrder(HttpServletRequest request, @RequestBody OrderDTO orderDto) {
		final String requestTokenHeader = request.getHeader("Authorization");
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			String jwtToken = requestTokenHeader.substring(7);
			try {
				String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
				User user = userService.findByUsername(username);

				Order order = new Order(user);
				orderService.save(order);

				float rate = Float.parseFloat(orderDto.getRate());
				float quantity = Float.parseFloat(orderDto.getQuantity());

				OrderList orderList = new OrderList(order, orderDto.getItem(), rate, quantity);
				orderListService.save(orderList);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

}
