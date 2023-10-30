package com.example.gurushotsdemo.presentation.photos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gurushotsdemo.domain.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase
) : ViewModel() {

    private val _photoIds = MutableStateFlow<List<String>>(emptyList())
    val photoIds: StateFlow<List<String>> = _photoIds

    private val _sideEffect = MutableSharedFlow<SideEffect>(replay = 1)
    val sideEffect: SharedFlow<SideEffect> = _sideEffect

    init {
        loadMorePhoto()
    }

    fun loadMorePhoto() {
        viewModelScope.launch {
            getPhotosUseCase.invoke(photoIds.value.size).fold(
                onSuccess = {
                    val listPhotoIds = mutableListOf<String>()
                    listPhotoIds.addAll(photoIds.value)
                    listPhotoIds.addAll(it)
                    _photoIds.value = listPhotoIds
                },
                onFailure = {
                    _sideEffect.tryEmit(SideEffect.NetworkError)
                }
            )
        }
    }

    sealed class SideEffect {
        object NetworkError : SideEffect()
    }
}