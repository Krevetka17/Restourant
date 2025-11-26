// domain/model/CartItem.kt
package md.restaurant.app.domain.model

import md.restaurant.app.data.remote.dto.MenuItemDto

data class CartItem(
    val menuItem: MenuItemDto,
    var quantity: Int = 1
)