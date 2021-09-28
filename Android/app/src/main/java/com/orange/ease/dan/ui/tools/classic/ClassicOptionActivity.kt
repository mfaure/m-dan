package com.orange.ease.dan.ui.tools.classic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.orange.ease.dan.databinding.OptionsTemplateBinding
import com.orange.ease.dan.model.OptionClassic
import com.orange.ease.dan.model.OptionRepository

class ClassicOptionActivity : AppCompatActivity() {

    private lateinit var binding: OptionsTemplateBinding

    private lateinit var viewModel: ClassicOptionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OptionsTemplateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(ClassicOptionViewModel::class.java)
        viewModel.option = OptionRepository.getCurrentOption()

        initView()
    }

    private fun initView() {
        val option = viewModel.option?.let { it } ?: return
        binding.optionDescription.text = getString((option as OptionClassic).description)

    }

    override fun onResume() {
        super.onResume()
        supportActionBar?.title = viewModel.option?.let { getString(it.title) }
    }
}

