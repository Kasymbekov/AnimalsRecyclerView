package com.example.animalsrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.animalsrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnItemLongClick {
    private lateinit var binding: ActivityMainBinding
    private val list: ArrayList<Animal> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addData(list)


        val adapter = AnimalAdapter(data = list, this)
        binding.recyclerview.adapter = adapter
    }

    private fun addData(list: ArrayList<Animal>) {
        list.add(
            Animal(
                "Lion",
                "https://www.pngkey.com/png/detail/973-9735128_lion-png-images-masai-lion.png"
            )

        )
        list.add(
            Animal(
                "Cat",
                "https://www.freeiconspng.com/thumbs/lion-png/amazing-lion-png-clipart-6.png"
            )

        )
        list.add(
            Animal(
                "Tiger",
                "https://cdn.britannica.com/40/75640-050-F894DD85/tiger-Siberian.jpg"
            )

        )
        list.add(
            Animal(
                "Dog",
                "https://ichef.bbci.co.uk/news/976/cpsprodpb/17638/production/_124800859_gettyimages-817514614.jpg"
            )

        )
        list.add(
            Animal(
                "Elephant",
                "https://s.abcnews.com/images/International/MChanga_1624536553868_hpMain_4x5_608.jpg"
            )

        )
        list.add(
            Animal(
                "Mouse",
                "https://thumbs.dreamstime.com/b/forest-mouse-went-walk-forest-mouse-summer-went-walk-find-their-own-food-stands-stone-against-159934712.jpg"
            )

        )
        list.add(
            Animal(
                "Horse",
                "https://cdn.sharechat.com/32255f78_1604582607910_sc.jpeg"
            )

        )
        list.add(
            Animal(
                "Bear",
                "https://images.unsplash.com/photo-1530595467537-0b5996c41f2d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8MXx8fGVufDB8fHx8&w=1000&q=80"
            )

        )
        list.add(
            Animal(
                "Giraffe",
                "https://cdn.mos.cms.futurecdn.net/mEuBJTDhXuTfSKdLefzSKg.jpg"
            )

        )
        list.add(
            Animal(
                "Panda",
                "https://i.pinimg.com/736x/43/d9/24/43d9243b3054e377c1869bea35d0b879.jpg"
            )

        )
        list.add(
            Animal(
                "Zebra",
                "https://animaldiversity.org/collections/contributors/Grzimek_mammals/Equiidae/Equus_zebra/medium.jpg"
            )

        )
        list.add(
            Animal(
                "Cow",
                "https://cdn4.vectorstock.com/i/1000x1000/71/88/cartoon-cow-cute-vector-27487188.jpg"
            )

        )
        list.add(
            Animal(
                "Wolf",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/6/68/Eurasian_wolf_2.jpg/1200px-Eurasian_wolf_2.jpg"
            )

        )

    }

    override fun onItemLongClick(position: Int) {
        val alert: AlertDialog.Builder = AlertDialog.Builder(this)
        alert.setTitle("Delete item")
        //method below is designed so that the user can't close dialog anywhere on the screen
        alert.setCancelable(false)
        alert.setMessage("Are you sure you want to delete this item?")
        alert.setIcon(R.drawable.ic_delete)
        alert.setPositiveButton("Yes") { dialog, which ->
            Toast.makeText(
                this,
                list.get(position).name + " item is deleted",
                Toast.LENGTH_SHORT
            ).show()
            list.remove(list.get(position))
            val adapter = AnimalAdapter(data = list, this)
            binding.recyclerview.adapter = adapter
        }
        alert.setNegativeButton("No") { dialog, which ->
            Toast.makeText(this, "Operation canceled", Toast.LENGTH_SHORT).show()
        }
        alert.create()
        alert.show()
    }
}