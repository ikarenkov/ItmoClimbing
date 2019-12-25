package com.itmoclimbing.feature.users.di.modules

import com.itmoclimbing.domainCommon.navigation.AppRouter
import com.itmoclimbing.feature.users.navigation.UsersScreenNavigation
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import toothpick.config.Module

class UsersNavigationModule : Module() {

    init {
        val cicerone = Cicerone.create(AppRouter())
        bind(AppRouter::class.java).withName(UsersScreenNavigation.NAME).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).withName(UsersScreenNavigation.NAME).toInstance(cicerone.navigatorHolder)
        bind(UsersScreenNavigation::class.java).to(UsersScreenNavigation::class.java).singleton()
    }

}