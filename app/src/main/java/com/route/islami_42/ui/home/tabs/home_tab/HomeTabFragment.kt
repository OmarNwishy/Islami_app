import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami_42.databinding.FragmentHomeTabBinding
import com.route.islami_42.models.SuraDM
import com.route.islami_42.ui.home.tabs.home_tab.SurAdapter
import com.route.islami_42.ui.suradetails.SuraDetailsActivity
import com.route.islami_42.utils.Constants

class HomeTabFragment : Fragment() {

    lateinit var binding: FragmentHomeTabBinding

    lateinit var adapter: SurAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = SurAdapter(
            surasList = SuraDM.generateSuraList(),
            onSuraClick = { sura ->
                val detailsIntent = Intent(context, SuraDetailsActivity::class.java)
                detailsIntent.putExtra(Constants.SURA_DETAILS_KEY, sura)
                activity.let {
                    it!!.startActivity(detailsIntent)
                }
            }
        )
        binding.rvSuras.adapter = adapter;
    }
}