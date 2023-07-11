import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ShoppingcartComponent } from './components/shoppingcart/shoppingcart.component';
import { InventoryComponent } from './components/inventory/inventory.component';

@NgModule({
  declarations: [
    AppComponent,
    ShoppingcartComponent,
    InventoryComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
