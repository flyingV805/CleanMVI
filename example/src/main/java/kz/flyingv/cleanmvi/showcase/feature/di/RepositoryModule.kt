package kz.flyingv.cleanmvi.showcase.feature.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kz.flyingv.cleanmvi.showcase.feature.data.repository.FeatureRepository
import kz.flyingv.cleanmvi.showcase.feature.data.repository.FeatureRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(): FeatureRepository {
        return FeatureRepositoryImpl()
    }


}