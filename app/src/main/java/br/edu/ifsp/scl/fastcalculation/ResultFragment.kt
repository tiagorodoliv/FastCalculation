package br.edu.ifsp.scl.fastcalculation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.ifsp.scl.fastcalculation.databinding.FragmentResultBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ResultFragment : Fragment() {
    private lateinit var fragmentResultBinding: FragmentResultBinding
    private lateinit var settings: Settings
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}