import { Component, Output, EventEmitter } from '@angular/core';
import { Subject } from 'rxjs';
import { ShoppingcartService } from 'src/app/services/shoppingcart.service';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.scss']
})
export class InventoryComponent {
  fruits: string[] = ['Apple', 'Orange', 'Banana', 'Mango', 'Kiwi', 'Pineapple'];

  @Output()
  private onFruitClick = new Subject<string>();

  constructor(private service:ShoppingcartService) { }

  addFruitToCart(fruit: HTMLButtonElement) {
    this.onFruitClick.next(fruit.value);
    this.service.changeDetection = true;
  }
}
