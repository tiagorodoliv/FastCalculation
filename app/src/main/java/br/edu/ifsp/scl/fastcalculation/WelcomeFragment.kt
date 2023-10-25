package br.edu.ifsp.scl.fastcalculation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import br.edu.ifsp.scl.fastcalculation.Extras.EXTRA_SETTINGS
import br.edu.ifsp.scl.fastcalculation.databinding.ActivityGameBinding
import br.edu.ifsp.scl.fastcalculation.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var fragmentWelcomeFragmentBinding: FragmentWelcomeBinding
    private lateinit var settings: Settings

    val point = fragmentManager.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            settings = it.getParcelable(EXTRA_SETTINGS) ?: Settings()
        }

        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentWelcomeFragmentBinding = FragmentWelcomeBinding.inflate(inflater, container, false)
        "${getString(R.string.welcome)},${settings.playerName}!".also {
            fragmentWelcomeFragmentBinding.welcomeTv.text = it
        }
        fragmentWelcomeFragmentBinding.playBt.setOnClickListener{
            (context as OnPlayGame).onPlayGame()
        }
        return fragmentWelcomeFragmentBinding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(settings: Settings) =
            WelcomeFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(EXTRA_SETTINGS, settings)
                }
            }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.restartGameMi).isVisible = false
    }
}