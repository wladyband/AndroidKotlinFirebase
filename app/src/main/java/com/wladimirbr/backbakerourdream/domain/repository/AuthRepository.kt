package com.wladimirbr.backbakerourdream.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.wladimirbr.backbakerourdream.domain.model.Response

interface AuthRepository {

    val currentUser: FirebaseUser?
    suspend fun login(email: String, password: String): Response<FirebaseUser>

}