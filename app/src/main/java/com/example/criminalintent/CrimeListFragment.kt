package com.example.criminalintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CrimeListFragment:Fragment() {
    lateinit var  crimeRecyclerViwe:RecyclerView
   private var adapter:CrimeAdspter?=null
    private val crimeListViewModle:CrimeListViweModle by lazy {
        ViewModelProviders.of(this).get(CrimeListViweModle::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    companion object{
        fun newInstance():CrimeListFragment{
            return CrimeListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       var viwe=inflater.inflate(R.layout.crime_list_fragment,container,false)
        crimeRecyclerViwe=viwe.findViewById(R.id.crime_recycler_viwe)
        crimeRecyclerViwe.layoutManager=LinearLayoutManager(context)
        adapter=CrimeAdspter(crimeListViewModle.crimes)
        crimeRecyclerViwe.adapter=adapter
        return view
    }
    private inner class CrimeViweHolder(viwe:View):RecyclerView.ViewHolder(viwe){
        val titleTextViwe:TextView=itemView.findViewById(R.id.crime_title)
        val dateTextViwe:TextView=itemView.findViewById(R.id.crime_data)
    }
    private inner class CrimeAdspter(var crimes:List<Crime>):RecyclerView.Adapter<CrimeViweHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeViweHolder {
        val viwe= layoutInflater.inflate(R.layout.list_item_crime,parent,false)
            return CrimeViweHolder(viwe)
        }

        override fun getItemCount(): Int {
            return crimes.size

        }

        override fun onBindViewHolder(holder: CrimeViweHolder, position: Int) {
           holder.titleTextViwe.setText(crimes[position].title)
            holder.dateTextViwe.setText(crimes[position].data.toString())
        }

    }
}


