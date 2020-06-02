package com.example.aqualang.di

import com.example.aqualang.education.coursesList.CoursesListFragment
import com.example.aqualang.login.login.LoginFragment
import com.example.aqualang.login.registration.RegistrationFragment
import com.example.data.database.DatabaseModule
import com.example.data.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, DatabaseModule::class, DomainModule::class])
@Singleton
interface AppComponent {
    fun inject(loginFragment: LoginFragment)
    fun inject(registrationFragment: RegistrationFragment)
    fun inject(coursesListFragment: CoursesListFragment)
}