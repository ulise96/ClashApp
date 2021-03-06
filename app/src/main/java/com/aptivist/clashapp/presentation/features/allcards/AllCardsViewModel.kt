package com.aptivist.clashapp.presentation.features.allcards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aptivist.clashapp.domain.repositories.RoyalAPIRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class AllCardsViewModel @Inject constructor(
    private val repository: RoyalAPIRepository
) : ViewModel() {
    private var _data = MutableLiveData<RequestViewState>()
    val data: LiveData<RequestViewState> get() = _data

    fun getAllCards() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repository.fetchAllCards()
                _data.postValue(RequestViewState.Success(result))
            } catch (e: Exception) {
                _data.postValue(RequestViewState.Error(e.message!!))
            }
        }
    }
    fun resetData() {
        _data.postValue(null)
    }
}