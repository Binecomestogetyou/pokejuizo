package com.bine.pokejuizo.move

import androidx.annotation.WorkerThread

class MoveRepository(private val moveDAO: MoveDAO) {

    val allMoves = moveDAO.getAllMoves()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun createMove(move: Move){
        moveDAO.addMove(move)
    }
}