package com.appagroup.domain

import com.appagroup.common.coroutines.ICoroutineContextProvider
import com.appagroup.domain.domainmodel.Result
import com.appagroup.domain.interactor.NoteInteractor
import com.appagroup.domain.repository.INoteRepository
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class NoteInteractorTest {

    lateinit var interactor: NoteInteractor

    val test = DomainTestObjects()

    @Mock
    lateinit var context: ICoroutineContextProvider

    @Mock
    lateinit var repo: INoteRepository

    @Before
    fun setup() {

        MockitoAnnotations.initMocks(this)

        interactor = NoteInteractor(repo, context)

    }

    @Test
    fun GetNotesSuccessfully() {

        //Unconfined is like Schedulers.trampoline()
        Mockito.`when`(context.provideBackgroundContext())
                .thenReturn(Dispatchers.Unconfined)

        Mockito.`when`(repo.getNotes())
                .thenReturn(Result.buildValue { listOf(test.TEST_NOTE, test.TEST_NOTE, test.TEST_NOTE) })

    }

    @Test
    fun GetNotesFailed() {


    }

}
