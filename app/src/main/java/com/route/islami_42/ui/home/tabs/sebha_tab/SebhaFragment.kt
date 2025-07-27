import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami_42.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {

    lateinit var  binding: FragmentSebhaBinding
    val tasabeehList = mutableListOf<String>()
    var tasbeehCount = 33
    var tasbeehIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSebhaBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getTasabeeh()
        initSebha()
        setupSebhaListener()
    }

    private fun setupSebhaListener() {
        binding.sebhaImageView.apply {
            setOnClickListener{
                updateCountAndTasbeeh()
            }
        }
    }

    private fun updateCountAndTasbeeh() {
        if(tasbeehCount == 1) {
            tasbeehCount = 33
            tasbeehIndex = (tasbeehIndex + 1) % tasabeehList.size
            binding.tasbeehCountTextView.text = "$tasbeehCount"
            binding.tasbeehTextView.text = tasabeehList[tasbeehIndex]
        } else {
            binding.tasbeehCountTextView.text = "${--tasbeehCount}"
        }
    }

    private fun initSebha() {
        binding.tasbeehTextView.text = tasabeehList[0]
        binding.tasbeehCountTextView.text = "$tasbeehCount"
    }


    private fun getTasabeeh() {
        val inputStream = requireActivity().assets.open("tsabeeh")
        val reader = inputStream.bufferedReader()
        var currentTasbeeh = reader.readLine()
        while(currentTasbeeh != null) {
            tasabeehList.add(currentTasbeeh)
            currentTasbeeh = reader.readLine()
        }
    }
}