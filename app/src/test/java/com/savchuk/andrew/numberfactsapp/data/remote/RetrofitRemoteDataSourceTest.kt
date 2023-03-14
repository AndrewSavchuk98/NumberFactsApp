package com.savchuk.andrew.numberfactsapp.data.remote

import com.savchuk.andrew.numberfactsapp.data.NumberData
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

internal class RetrofitRemoteDataSourceTest {

    private val service = mockk<FactsApi>()
    private val mapper = mockk<ResponseMapper>()

    @Test
    fun `get number fact from service`() = runTest {

        val serviceResponse = "1 fact about number 1"
        val  expectedOutput = NumberData("1", "fact about number 1")

        coEvery { service.getNumberFact("1") } returns
                serviceResponse
        every { mapper.map(serviceResponse) } returns
                NumberData("1", "fact about number 1")

        val dataSource = RetrofitRemoteDataSource(service, mapper)

        val actual = dataSource.getNumberFact("1")

        assertEquals(expectedOutput, actual)
    }

    @Test
    fun `check random number fact result`() = runTest{

        val serviceResponse = "1 random fact about number 1"
        val  expectedOutput = NumberData("1", "random fact about number 1")

        coEvery { service.getRandomFact() } returns
                serviceResponse
        every { mapper.map(serviceResponse) } returns
                NumberData("1", "random fact about number 1")

        val dataSource = RetrofitRemoteDataSource(service, mapper)

        val actual = dataSource.getRandomFact()

        assertEquals(expectedOutput, actual)
    }


}