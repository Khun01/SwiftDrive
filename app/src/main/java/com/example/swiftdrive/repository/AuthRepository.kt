package com.example.swiftdrive.repository

import android.util.Log
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class AuthRepository(private val auth: FirebaseAuth){

    val firestore = FirebaseFirestore.getInstance()

    fun registerUser(email: String, password: String) = flow {
        try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            val user = result.user

            if (user != null) {
                Log.d("AuthRepository", "User Created: UID=${user.uid}, Email=${user.email}")
                emit(Result.success(result))
            } else {
                Log.e("AuthRepository", "User is NULL after registration!")
                emit(Result.failure(Exception("User is NULL")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    fun loginUser(email: String, password: String): Flow<Result<AuthResult>> = flow {
        try{
            val result = auth.signInWithEmailAndPassword(email, password).await()
            emit(Result.success(result))
        }catch (e: Exception){
            emit(Result.failure(e))
        }
    }
}