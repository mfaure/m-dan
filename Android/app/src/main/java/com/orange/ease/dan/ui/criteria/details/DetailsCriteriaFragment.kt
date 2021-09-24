package com.orange.ease.dan.ui.criteria.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.orange.ease.dan.databinding.RecyclerViewFragmentBinding
import com.orange.ease.dan.model.Example

class DetailsCriteriaFragment: Fragment(), ListExampleRecyclerViewAdapter.ListExampleRecyclerViewClickListener {

    private lateinit var binding: RecyclerViewFragmentBinding
    private lateinit var viewModel: CriteriaDetailsViewModel
    private lateinit var mContext : Context

    companion object {
        fun newInstance() = DetailsCriteriaFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RecyclerViewFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(CriteriaDetailsViewModel::class.java)
        initExample()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    private fun initExample() {
        binding.listsRecyclerview.layoutManager = LinearLayoutManager(mContext)

        val headerAdapter = DetailsHeaderAdapter(viewModel.criteria, mContext)
        val recyclerViewAdapter =
            this.context?.let { ListExampleRecyclerViewAdapter(viewModel.criteria!!.exampleList, this, it) }

        val concatAdapter = ConcatAdapter(headerAdapter, recyclerViewAdapter)
        binding.listsRecyclerview.adapter = concatAdapter
    }

    override fun listItemClicked(example: Example) {
        viewModel.setCurrentExample(example)
        (activity as DetailsCriteriaActivity?)?.let {
            it.updateFragmentWithExample()
        }
    }
}

