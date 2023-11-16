package com.wladimirbr.backbakerourdream.di

import com.google.firebase.auth.FirebaseAuth
import com.wladimirbr.backbakerourdream.data.repository.AuthRepositoryImpl
import com.wladimirbr.backbakerourdream.domain.repository.AuthRepository
import com.wladimirbr.backbakerourdream.domain.use_cases.auth.AuthUseCases
import com.wladimirbr.backbakerourdream.domain.use_cases.auth.GetCurrentUser
import com.wladimirbr.backbakerourdream.domain.use_cases.auth.Login
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class )
@Module
object AppModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun privideAuthUseCases(repository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository)
    )
}