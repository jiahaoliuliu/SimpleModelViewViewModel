package com.jiahaoliuliu.simplemodelviewviewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

@HiltViewModel
class UserProfileViewModel @Inject constructor(savedStateHandle: SavedStateHandle,
    userRepository: UserRepository): ViewModel() {
    val userId: String = savedStateHandle["uid"] ?: throw IllegalArgumentException("Missing user id")
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    init {
        viewModelScope.launch {
            _user.value = userRepository.getUser(userId);
        }
    }
}

data class User(val name: String)