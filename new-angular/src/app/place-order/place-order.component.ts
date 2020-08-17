import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.css']
})
export class PlaceOrderComponent implements OnInit {
  isLoggedIn = false;
  form: any = {};
  items = [
      { name: "item1", price: "10", },
      { name: "item2", price: "20", },
      { name: "item3", price: "30", },
      { name: "item4", price: "40", },
    ];

  constructor(private userService: UserService, private tokenStorage: TokenStorageService) {}

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
    }
  }

  placeOrderSubmit() {
    this.userService.placeOrder(this.form).subscribe(
      data => {
        document.getElementById("js-form").style.display = "none";
        document.getElementById("js-alert-success").style.display = "block";
      },
      err => {
        document.getElementById("js-form").style.display = "none";
        document.getElementById("js-alert-danger").style.display = "block";
      }
    );
  }

}
