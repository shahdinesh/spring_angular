import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  isLoggedIn = false;
  allOrders: any;
  constructor(private userService: UserService, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
    }

    this.userService.getOrders().subscribe(
      data => {
        this.allOrders = data;
      },
      err => {
      }
    );
  }

  markPaid(orderId) {
    this.userService.markPaid(orderId).subscribe(
      data => {
        document.getElementById("paid-btn-" + orderId).parentElement.innerHTML = "<span class='text-success'>Paid</span>";
      },
      err => {
      }
    );
  }

}
