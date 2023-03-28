package com.nc.cinemarecs.presentation.recommendations

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nc.cinemarecs.domain.entities.CinemaEntity
import com.nc.cinemarecs.domain.usecases.GetCinemaRecommendationsUseCase
import com.nc.cinemarecs.domain.usecases.UpdateCinemaRecommendationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecommendationsViewModel @Inject constructor(
    private val getCinemaRecommendationsUseCase: GetCinemaRecommendationsUseCase,
    private val updateCinemaRecommendationsUseCase: UpdateCinemaRecommendationsUseCase
): ViewModel() {

    private val _recommendationsLiveData = MutableLiveData<List<CinemaEntity>>()
    val recommendationsLiveData: LiveData<List<CinemaEntity>>
        get() = _recommendationsLiveData

    fun updateRecommendations() {

    }

    fun getRecommendations() {
        viewModelScope.launch(Dispatchers.IO) {
            updateCinemaRecommendationsUseCase.execute()
            _recommendationsLiveData.postValue(getCinemaRecommendationsUseCase.execute())
        }
    }

}