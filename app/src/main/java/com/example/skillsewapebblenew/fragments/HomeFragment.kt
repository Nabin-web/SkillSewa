package com.example.skillsewapebblenew.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.skillsewapebblenew.Adapter.*

import com.example.skillsewapebblenew.R
import com.example.skillsewapebblenew.dataClass.pdfData
import com.example.skillsewapebblenew.repository.pdfRepository
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    lateinit var newImageView: ImageView
//    private lateinit var linearLayout: LinearLayout
    private lateinit var RecyclerView: RecyclerView
    private lateinit var RecyclerView1: RecyclerView
    private lateinit var RecyclerView2: RecyclerView
    private lateinit var RecyclerView3: RecyclerView
    private lateinit var RecyclerView4: RecyclerView
    private lateinit var RecyclerView5: RecyclerView



    private lateinit var addImageView: Button
    private lateinit var addImageView1: Button
    private lateinit var addImageView2: Button
    private lateinit var addImageView3: Button
    private lateinit var addImageView4: Button
    private lateinit var addImageView5: Button
    private lateinit var btnGeneratePdf: Button



    private lateinit var etHouseOwner: EditText
    private lateinit var etLocation: EditText
    private lateinit var etNameOfHouseInspector: EditText
    private lateinit var etDateOfInspection: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

//        linearLayout = root.findViewById(R.id.linearLayout1)
        RecyclerView = root.findViewById(R.id.recyclerView)
        RecyclerView1 = root.findViewById(R.id.recyclerView1)
        RecyclerView2 = root.findViewById(R.id.recyclerView2)
        RecyclerView3 = root.findViewById(R.id.recyclerView3)
        RecyclerView4 = root.findViewById(R.id.recyclerView4)
        RecyclerView5 = root.findViewById(R.id.recyclerView5)

        addImageView = root.findViewById(R.id.addImageView)
        addImageView1 = root.findViewById(R.id.addImageView1)
        addImageView2 = root.findViewById(R.id.addImageView2)
        addImageView3 = root.findViewById(R.id.addImageView3)
        addImageView4 = root.findViewById(R.id.addImageView4)
        addImageView5 = root.findViewById(R.id.addImageView5)
        btnGeneratePdf = root.findViewById(R.id.btnGeneratePdf)



        val adapter = GroupAdapter<GroupieViewHolder>()
        val adapter1 = GroupAdapter<GroupieViewHolder>()
        val adapter2= GroupAdapter<GroupieViewHolder>()
        val adapter3= GroupAdapter<GroupieViewHolder>()
        val adapter4= GroupAdapter<GroupieViewHolder>()
        val adapter5= GroupAdapter<GroupieViewHolder>()

        RecyclerView.layoutManager = LinearLayoutManager(container!!.context)
        RecyclerView1.layoutManager = LinearLayoutManager(container.context)
        RecyclerView2.layoutManager = LinearLayoutManager(container.context)
        RecyclerView3.layoutManager = LinearLayoutManager(container.context)
        RecyclerView4.layoutManager = LinearLayoutManager(container.context)
        RecyclerView5.layoutManager = LinearLayoutManager(container.context)


        addImageView.setOnClickListener {
            adapter.add(AdapterImage0())
            adapter.notifyDataSetChanged()
            RecyclerView.smoothScrollToPosition(adapter.getItemCount())
        }

        addImageView1.setOnClickListener {
            adapter1.add(AdapterImage1())
            adapter1.notifyDataSetChanged()
            RecyclerView2.smoothScrollToPosition(adapter.getItemCount())
        }


        addImageView2.setOnClickListener {
            adapter2.add(AdapterImage2())
            adapter2.notifyDataSetChanged()
            RecyclerView2.smoothScrollToPosition(adapter.getItemCount())
        }

        addImageView3.setOnClickListener {
            adapter3.add(AdapterImage3())
            adapter3.notifyDataSetChanged()
            RecyclerView2.smoothScrollToPosition(adapter.getItemCount())
        }

        addImageView4.setOnClickListener {
            adapter4.add(AdapterImage4())
            adapter4.notifyDataSetChanged()
            RecyclerView2.smoothScrollToPosition(adapter.getItemCount())
        }

        addImageView5.setOnClickListener {
            adapter5.add(AdapterImage5())
            adapter5.notifyDataSetChanged()
            RecyclerView2.smoothScrollToPosition(adapter.getItemCount())
        }


        RecyclerView.adapter = adapter
        RecyclerView1.adapter = adapter1
        RecyclerView2.adapter= adapter2
        RecyclerView3.adapter= adapter3
        RecyclerView4.adapter= adapter4
        RecyclerView5.adapter= adapter5

        etHouseOwner= root.findViewById(R.id.etHouseOwner)
        etLocation= root.findViewById(R.id.etLocation)
        etNameOfHouseInspector = root.findViewById(R.id.etNameOfHouseInspector)
        etDateOfInspection = root.findViewById(R.id.etDateOfInspection)


       

        btnGeneratePdf.setOnClickListener {
            val data = pdfData(HouseOwner = etHouseOwner.text.toString() ,Location = etLocation.text.toString() ,
                    NameOfHouseInspector = etNameOfHouseInspector.text.toString() , DateOfInspection = etDateOfInspection.text.toString())


            Toast.makeText(context, "${data}", Toast.LENGTH_SHORT).show()

            CoroutineScope(Dispatchers.IO).launch {

                try {

                    val repository = pdfRepository()
                    val response = repository.insertPdfData(data)

                    if (response.success== true){
//                        Toast.makeText(context, "Data inserted", Toast.LENGTH_SHORT).show()
                    }
                }
                catch(ex:Exception){
//                    Toast.makeText(context, "${ex}", Toast.LENGTH_SHORT).show()
                    print(ex.toString())
                }

            }
        }



        return root
    }

}