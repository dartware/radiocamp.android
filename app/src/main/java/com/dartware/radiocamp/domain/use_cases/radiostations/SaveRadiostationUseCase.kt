package com.dartware.radiocamp.domain.use_cases.radiostations

import com.dartware.radiocamp.domain.models.Radiostation
import com.dartware.radiocamp.domain.repositories.RadiostationsRepository
import javax.inject.Inject

class SaveRadiostationUseCase @Inject constructor(
    private val radiostationsRepository: RadiostationsRepository
) {
    suspend operator fun invoke(radiostation: Radiostation) {
        radiostationsRepository.save(radiostation)
    }
}