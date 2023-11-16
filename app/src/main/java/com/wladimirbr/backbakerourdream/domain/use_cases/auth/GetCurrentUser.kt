package com.wladimirbr.backbakerourdream.domain.use_cases.auth

import com.wladimirbr.backbakerourdream.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser @Inject constructor(private val repository: AuthRepository) {
    operator  fun invoke() = repository.currentUser
}