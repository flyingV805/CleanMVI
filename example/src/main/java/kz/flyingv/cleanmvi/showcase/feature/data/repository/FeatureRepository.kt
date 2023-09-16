package kz.flyingv.cleanmvi.showcase.feature.data.repository

import kz.flyingv.cleanmvi.showcase.feature.domain.entity.CatFact

interface FeatureRepository {

    suspend fun getCatFact(): CatFact?

}