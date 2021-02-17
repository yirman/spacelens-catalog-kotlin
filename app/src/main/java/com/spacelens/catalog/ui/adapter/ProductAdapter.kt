package com.spacelens.catalog.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.spacelens.catalog.R
import com.spacelens.catalog.model.Product
import com.spacelens.catalog.ui.activity.ProductDetailActivity
import io.realm.RealmResults

class ProductAdapter(var context: Context, var products: RealmResults<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.item_product, parent, false) as View
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.tvProductTitle.text = product?.title
        holder.tvProductDescription.text = product?.description
        Glide.with(context)
            .load(product?.attachment?.url)
            .centerInside()
            .into(holder.ivPhoto)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra(ProductDetailActivity.EXTRA_PRODUCT_ID, product?.productId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }


    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var ivPhoto : ImageView = itemView.findViewById(R.id.iv_product_image)
        var tvProductTitle : TextView =  itemView.findViewById(R.id.tv_product_title)
        var tvProductDescription : TextView =  itemView.findViewById(R.id.tv_product_description)

    }


}