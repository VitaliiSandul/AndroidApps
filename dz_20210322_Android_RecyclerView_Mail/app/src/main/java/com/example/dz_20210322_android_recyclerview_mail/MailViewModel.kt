package com.example.dz_20210322_android_recyclerview_mail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MailViewModel : ViewModel() {
    var emails: MutableLiveData<List<Mail>> = MutableLiveData()
    var tmpMailList: ArrayList<Mail> = ArrayList<Mail>()

    init{
        emails.value = MailData.getMails()
        MailData.getMails().forEach { tmpMailList.add(it) }
    }

    fun getMailList() = emails

//    fun clearMailList(){
////        mailList.value = MailData.getClearList()
////        tmpMailList  = ArrayList<Mail>()
////    }

}