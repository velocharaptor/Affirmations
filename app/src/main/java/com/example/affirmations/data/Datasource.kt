package com.example.affirmations.data

import android.content.Context
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation
import com.example.affirmations.model.Data

class Datasource() {

    fun loadAffirmations(context: Context): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(context.resources.getString(R.string.affirmation1), "https://img.detmir.st/rfytAzl7DoK4_su36Mt7Kcgv_RgGPQsrQC9EHms-hio/rs:fit:2448:2448/g:sm/ex:1/bg:FFFFFF/aHR0cHM6Ly9zdGF0aWMuZGV0bWlyLnN0L21lZGlhX3BpbS82MzkvNTcyLzM1NzI2MzkvMTUwMC8wLmpwZz8xNjY4MTg1MTE0MDEw.webp"),
            Affirmation(context.resources.getString(R.string.affirmation2), "https://img.detmir.st/rfytAzl7DoK4_su36Mt7Kcgv_RgGPQsrQC9EHms-hio/rs:fit:2448:2448/g:sm/ex:1/bg:FFFFFF/aHR0cHM6Ly9zdGF0aWMuZGV0bWlyLnN0L21lZGlhX3BpbS82MzkvNTcyLzM1NzI2MzkvMTUwMC8wLmpwZz8xNjY4MTg1MTE0MDEw.webp"),
            Affirmation(context.resources.getString(R.string.affirmation3), "https://img.detmir.st/rfytAzl7DoK4_su36Mt7Kcgv_RgGPQsrQC9EHms-hio/rs:fit:2448:2448/g:sm/ex:1/bg:FFFFFF/aHR0cHM6Ly9zdGF0aWMuZGV0bWlyLnN0L21lZGlhX3BpbS82MzkvNTcyLzM1NzI2MzkvMTUwMC8wLmpwZz8xNjY4MTg1MTE0MDEw.webp"),
            Affirmation(context.resources.getString(R.string.affirmation4), "https://img.detmir.st/rfytAzl7DoK4_su36Mt7Kcgv_RgGPQsrQC9EHms-hio/rs:fit:2448:2448/g:sm/ex:1/bg:FFFFFF/aHR0cHM6Ly9zdGF0aWMuZGV0bWlyLnN0L21lZGlhX3BpbS82MzkvNTcyLzM1NzI2MzkvMTUwMC8wLmpwZz8xNjY4MTg1MTE0MDEw.webp"),
            Affirmation(context.resources.getString(R.string.affirmation5), "https://img.detmir.st/rfytAzl7DoK4_su36Mt7Kcgv_RgGPQsrQC9EHms-hio/rs:fit:2448:2448/g:sm/ex:1/bg:FFFFFF/aHR0cHM6Ly9zdGF0aWMuZGV0bWlyLnN0L21lZGlhX3BpbS82MzkvNTcyLzM1NzI2MzkvMTUwMC8wLmpwZz8xNjY4MTg1MTE0MDEw.webp"),
            Affirmation(context.resources.getString(R.string.affirmation6), "https://img.detmir.st/rfytAzl7DoK4_su36Mt7Kcgv_RgGPQsrQC9EHms-hio/rs:fit:2448:2448/g:sm/ex:1/bg:FFFFFF/aHR0cHM6Ly9zdGF0aWMuZGV0bWlyLnN0L21lZGlhX3BpbS82MzkvNTcyLzM1NzI2MzkvMTUwMC8wLmpwZz8xNjY4MTg1MTE0MDEw.webp"),
            Affirmation(context.resources.getString(R.string.affirmation7), "https://img.detmir.st/rfytAzl7DoK4_su36Mt7Kcgv_RgGPQsrQC9EHms-hio/rs:fit:2448:2448/g:sm/ex:1/bg:FFFFFF/aHR0cHM6Ly9zdGF0aWMuZGV0bWlyLnN0L21lZGlhX3BpbS82MzkvNTcyLzM1NzI2MzkvMTUwMC8wLmpwZz8xNjY4MTg1MTE0MDEw.webp"),
            Affirmation(context.resources.getString(R.string.affirmation8), "https://img.detmir.st/rfytAzl7DoK4_su36Mt7Kcgv_RgGPQsrQC9EHms-hio/rs:fit:2448:2448/g:sm/ex:1/bg:FFFFFF/aHR0cHM6Ly9zdGF0aWMuZGV0bWlyLnN0L21lZGlhX3BpbS82MzkvNTcyLzM1NzI2MzkvMTUwMC8wLmpwZz8xNjY4MTg1MTE0MDEw.webp"),
            Affirmation(context.resources.getString(R.string.affirmation9), "https://img.detmir.st/rfytAzl7DoK4_su36Mt7Kcgv_RgGPQsrQC9EHms-hio/rs:fit:2448:2448/g:sm/ex:1/bg:FFFFFF/aHR0cHM6Ly9zdGF0aWMuZGV0bWlyLnN0L21lZGlhX3BpbS82MzkvNTcyLzM1NzI2MzkvMTUwMC8wLmpwZz8xNjY4MTg1MTE0MDEw.webp"),
            Affirmation(context.resources.getString(R.string.affirmation10), "https://img.detmir.st/rfytAzl7DoK4_su36Mt7Kcgv_RgGPQsrQC9EHms-hio/rs:fit:2448:2448/g:sm/ex:1/bg:FFFFFF/aHR0cHM6Ly9zdGF0aWMuZGV0bWlyLnN0L21lZGlhX3BpbS82MzkvNTcyLzM1NzI2MzkvMTUwMC8wLmpwZz8xNjY4MTg1MTE0MDEw.webp"),
        )
    }

    fun loadData(context: Context): List<Data>{
        return listOf<Data>(
            Data.FirstType(context.resources.getString(R.string.affirmation1), "https://img.detmir.st/rfytAzl7DoK4_su36Mt7Kcgv_RgGPQsrQC9EHms-hio/rs:fit:2448:2448/g:sm/ex:1/bg:FFFFFF/aHR0cHM6Ly9zdGF0aWMuZGV0bWlyLnN0L21lZGlhX3BpbS82MzkvNTcyLzM1NzI2MzkvMTUwMC8wLmpwZz8xNjY4MTg1MTE0MDEw.webp"),
            Data.FirstType(context.resources.getString(R.string.affirmation1), "https://img.detmir.st/rfytAzl7DoK4_su36Mt7Kcgv_RgGPQsrQC9EHms-hio/rs:fit:2448:2448/g:sm/ex:1/bg:FFFFFF/aHR0cHM6Ly9zdGF0aWMuZGV0bWlyLnN0L21lZGlhX3BpbS82MzkvNTcyLzM1NzI2MzkvMTUwMC8wLmpwZz8xNjY4MTg1MTE0MDEw.webp"),
            Data.SecondType("https://img.detmir.st/rfytAzl7DoK4_su36Mt7Kcgv_RgGPQsrQC9EHms-hio/rs:fit:2448:2448/g:sm/ex:1/bg:FFFFFF/aHR0cHM6Ly9zdGF0aWMuZGV0bWlyLnN0L21lZGlhX3BpbS82MzkvNTcyLzM1NzI2MzkvMTUwMC8wLmpwZz8xNjY4MTg1MTE0MDEw.webp"),
            Data.SecondType("https://img.detmir.st/rfytAzl7DoK4_su36Mt7Kcgv_RgGPQsrQC9EHms-hio/rs:fit:2448:2448/g:sm/ex:1/bg:FFFFFF/aHR0cHM6Ly9zdGF0aWMuZGV0bWlyLnN0L21lZGlhX3BpbS82MzkvNTcyLzM1NzI2MzkvMTUwMC8wLmpwZz8xNjY4MTg1MTE0MDEw.webp"),
        )
    }
}