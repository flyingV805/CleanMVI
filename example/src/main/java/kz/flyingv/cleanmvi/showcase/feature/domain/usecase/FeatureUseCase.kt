package kz.flyingv.cleanmvi.showcase.feature.domain.usecase

import kz.flyingv.cleanmvi.showcase.feature.data.repository.FeatureRepository
import kz.flyingv.cleanmvi.showcase.feature.domain.entity.CatFact
import javax.inject.Inject

class FeatureUseCase @Inject constructor(
    private val featureRepository: FeatureRepository
) {

    suspend operator fun invoke(): CatFact? {
        return featureRepository.getCatFact()
    }

}