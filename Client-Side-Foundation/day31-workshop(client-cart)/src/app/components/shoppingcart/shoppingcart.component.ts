import { Component, Input, OnChanges, OnInit, Output } from '@angular/core';
import { ShoppingcartService } from 'src/app/services/shoppingcart.service';

@Component({
  selector: 'app-shoppingcart',
  templateUrl: './shoppingcart.component.html',
  styleUrls: ['./shoppingcart.component.scss']
})
export class ShoppingcartComponent implements OnChanges, OnInit {
  @Input()
  receivedFruit!: string;

  private forceDetection: boolean = false;
  constructor(private service:ShoppingcartService) { }

  cartList: Map<string, number> = new Map<string, number>();

  ngOnInit(): void {
    this.cartList.clear();
  }

  ngOnChanges(): void {
    // this.forceChangeDetection();
    if (this.cartList.has(this.receivedFruit)) {
      let count = this.cartList.get(this.receivedFruit);
      if (count) {
        this.cartList.set(this.receivedFruit, count + 1);
      }
    } else {
      this.cartList.set(this.receivedFruit, 1);
    }

  }

  deleteFruit(fruit: HTMLButtonElement): void {
    this.cartList.delete(fruit.value);
  }

  forceChangeDetection() {
    this.forceDetection = true;
    this.receivedFruit = this.receivedFruit;
  }
}
