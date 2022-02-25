package ru.gb.weatherapp.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.gb.weatherapp.R
import ru.gb.weatherapp.databinding.FragmentDetailsBinding
import ru.gb.weatherapp.model.Weather

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<Weather>(BUNDLE_EXTRA)?.let{
            it.city.also{
                binding.cityName.text = it.city

                binding.cityCoordinates.text = String.format(
                    getString(R.string.city_coordinates),
                    it.lat.toString(),
                    it.lon.toString()
                )
            }
            binding.temperatureValue.text = it.temperature.toString()
            binding.feelsLikeValue.text = it.feelsLike.toString()
        }

        val weather = arguments?.getParcelable<Weather>(BUNDLE_EXTRA)

        if (weather != null) {
            val city = weather.city
            binding.cityName.text = city.city

            binding.cityCoordinates.text = String.format(
                getString(R.string.city_coordinates),
                city.lat.toString(),
                city.lon.toString()
            )
            binding.temperatureValue.text = weather.temperature.toString()
            binding.feelsLikeValue.text = weather.feelsLike.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        const val BUNDLE_EXTRA = "weather"

        fun newInstance(bundle: Bundle): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}