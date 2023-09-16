package kz.flyingv.cleanmvi.showcase.feature.data.repository

import kotlinx.coroutines.delay
import kz.flyingv.cleanmvi.showcase.feature.domain.entity.CatFact

class FeatureRepositoryImpl : FeatureRepository {

    override suspend fun getCatFact(): CatFact? {
        delay(5000)
        return CatFact("NEW FACT")
    }

}