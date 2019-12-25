package com.itmoclimbing.internal.di

import com.itmoclimbing.domainCommon.navigation.AppRouter
import com.itmoclimbing.presentation.screens.main.MainScreenNavigation
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import toothpick.config.Module

class MainNavigationModule : Module() {

    init {
        val cicerone = Cicerone.create(AppRouter())
        bind(AppRouter::class.java).withName(MainScreenNavigation.NAME).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).withName(MainScreenNavigation.NAME).toInstance(cicerone.navigatorHolder)
        bind(MainScreenNavigation::class.java).to(MainScreenNavigation::class.java).singleton()
    }

}