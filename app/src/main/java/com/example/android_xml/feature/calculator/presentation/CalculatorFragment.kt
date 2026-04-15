package com.example.android_xml.feature.calculator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android_xml.databinding.CalculatorFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CalculatorFragment : Fragment() {

    private val viewModel: CalculatorViewModel by viewModel()

    private var _binding: CalculatorFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CalculatorFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        viewModel.display.observe(viewLifecycleOwner) {
            binding.textResult.text = it
        }

        listOf(
            binding.btnOne to "1",
            binding.btnTwo to "2",
            binding.btnThree to "3",
            binding.btnFour to "4",
            binding.btnFive to "5",
            binding.btnSix to "6",
            binding.btnSeven to "7",
            binding.btnEight to "8",
            binding.btnNine to "9",
            binding.btnZero to "0"
        ).forEach { (viewButton, value) ->
            viewButton.setOnClickListener {
                viewModel.appendDigit(value)
            }
        }

        listOf(
            binding.btnPlus to "+",
            binding.btnMinus to "-",
            binding.btnMultiply to "*",
            binding.btnDivide to "/"
        ).forEach { (viewButton, value) ->
            viewButton.setOnClickListener {
                viewModel.appendOperator(value)
            }
        }

        binding.btnC.setOnClickListener {
            viewModel.clear()
        }

        binding.btnEquals.setOnClickListener {
            viewModel.calculate()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
