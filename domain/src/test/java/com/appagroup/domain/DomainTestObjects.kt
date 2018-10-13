package com.appagroup.domain

import com.appagroup.domain.domainmodel.Note

class DomainTestObjects {

    val TEST_NOTE_DATE = 12312313123

    val TEST_NOTE_NAME = "test note name"

    val TEST_NOTE_DESCRIPTION = "test note description"

    val TEST_NOTE = Note(TEST_NOTE_DATE,
            TEST_NOTE_NAME,
            TEST_NOTE_DESCRIPTION)
}
