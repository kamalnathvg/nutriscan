package com.mdev.feature_profile.presentation.profilePage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdev.client_firebase.data.remote.dto.AppUser
import com.mdev.common.utils.Resource
import com.mdev.common.utils.domain.model.Status
import com.mdev.feature_profile.domain.usecases.GetProfileDetailsUseCase
import com.mdev.feature_profile.domain.usecases.UpdateProfileDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class ProfilePageState(
    val profileUpdateStatus: Status = Status.IDLE,
    val getProfileDetailsStatus: Status = Status.IDLE,
    val errorMessage: String? = null,
    val appUser: AppUser? = null,
)


@HiltViewModel
class ProfilePageViewModel @Inject constructor(
    private val getProfileDetailsUseCase: GetProfileDetailsUseCase,
    private val updateProfileDetailsUseCase: UpdateProfileDetailsUseCase
    ): ViewModel() {
    private val _uiState = MutableStateFlow(ProfilePageState())
    val uiState = _uiState.asStateFlow()

    init{
        getUserProfileDetails()
    }

    fun onEvent(event: ProfilePageEvent){
        when(event){
            is ProfilePageEvent.GetUserProfileDetails -> getUserProfileDetails()
            is ProfilePageEvent.UpdateProfileDetails -> updateUserProfileDetails(event.appUser)
        }
    }

    private fun updateUserProfileDetails(appUser: AppUser) {
        updateProfileDetailsUseCase(appUser).onEach { result ->
            when(result){
                is Resource.Error -> {
                    _uiState.update {
                        ProfilePageState(
                            profileUpdateStatus = Status.FAILURE,
                            errorMessage = result.message
                        )
                    }
                }
                is Resource.Loading -> {
                    _uiState.update {
                        ProfilePageState(
                            profileUpdateStatus = Status.LOADING
                        )
                    }
                }
                is Resource.Success -> {
                    _uiState.update {
                        ProfilePageState(
                            profileUpdateStatus = Status.SUCCESS,
                            appUser = result.data
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getUserProfileDetails() {
        getProfileDetailsUseCase().onEach { result ->
            when(result){
                is Resource.Error -> {
                    _uiState.update {
                        ProfilePageState(
                            getProfileDetailsStatus = Status.FAILURE,
                            errorMessage = result.message
                        )
                    }
                }
                is Resource.Loading -> {
                    _uiState.update {
                        ProfilePageState(
                            getProfileDetailsStatus = Status.LOADING
                        )
                    }
                }
                is Resource.Success -> {
                    _uiState.update {
                        ProfilePageState(
                            getProfileDetailsStatus = Status.SUCCESS,
                            appUser = result.data
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}