package com.example.ranfomfactnumbers.main.di

import com.example.ranfomfactnumbers.BuildConfig
import com.example.ranfomfactnumbers.numbers.data.cache.CacheModule
import com.example.ranfomfactnumbers.numbers.data.cloud.CloudModule
import com.example.ranfomfactnumbers.numbers.presentation.DispatchersList
import com.example.ranfomfactnumbers.numbers.presentation.ManageResources
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val coreModule = module {

//    val module = /*if (BuildConfig.DEBUG) codeModuleDebug else*/ codeModuleRelease
//    includes(module)

    single<CloudModule> { CloudModule.Release() }
    single<DispatchersList> { DispatchersList.Base() }
    single<ManageResources> { ManageResources.Base(androidContext()) }
    single<CacheModule> { CacheModule.Base(androidContext()) }

}

private val codeModuleRelease = module {
    single<CloudModule> { CloudModule.Release() }
    single<DispatchersList> { DispatchersList.Base() }
    single<ManageResources> { ManageResources.Base(androidContext()) }
    single<CacheModule> { CacheModule.Base(androidContext()) }
}

private val codeModuleDebug = module {
    single { CloudModule.Debug() }
    single { DispatchersList.Base() }
    single { ManageResources.Base(androidContext()) }
    single { CacheModule.Mock(androidContext()) }
}