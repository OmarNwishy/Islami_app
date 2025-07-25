import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami_42.databinding.FragmentHadethBinding
import com.route.islami_42.models.HadethDM
import com.route.islami_42.ui.hadeth_details.HadethDetailsActivity
import com.route.islami_42.ui.home.tabs.hadeth_tab.AhadethAdapter
import com.route.islami_42.utils.Constants.Companion.HADETH_KEY


class HadethFragment : Fragment() {

    lateinit var binding: FragmentHadethBinding
    var ahadeth: ArrayList<HadethDM> = ArrayList()
    var adapter = AhadethAdapter(ahadeth){ hadeth ->
        val intent = Intent(requireContext(), HadethDetailsActivity::class.java)
        intent.putExtra(HADETH_KEY, hadeth)
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHadethBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAhadethRecyclerView()
        readHadethFile()

    }

    private fun initAhadethRecyclerView() {
        binding.ahadethRecycler.adapter = adapter
        // Configure carousel effect
        binding.ahadethRecycler.setOffscreenPageLimit(3) // Keep adjacent pages in memory
        binding.ahadethRecycler.clipChildren = false
        binding.ahadethRecycler.clipToPadding = false

    }

    private fun readHadethFile() {
        val inputStream = requireActivity().assets.open("ahadeth.txt")
        val reader = inputStream.bufferedReader()

        var line = reader.readLine()
        val hadethLines = ArrayList<String>()
        while (line != null) {
            if (line.trim() != "#") {
                hadethLines.add(line)
            }
            if (line.trim() == "#") {
                val title = hadethLines[0]
                hadethLines.removeAt(0)
                val content: String = hadethLines.joinToString(separator = " ")
                ahadeth.add(HadethDM(title = title, content = content))
                hadethLines.clear()
            }
            line = reader.readLine()
        }
    }

}