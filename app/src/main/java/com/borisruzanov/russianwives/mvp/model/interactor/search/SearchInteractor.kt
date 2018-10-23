package com.borisruzanov.russianwives.mvp.model.interactor.search

import com.borisruzanov.russianwives.mvp.model.repository.filter.FilterRepository
import com.borisruzanov.russianwives.mvp.model.repository.friend.FriendRepository
import com.borisruzanov.russianwives.mvp.model.repository.search.SearchRepository
import com.borisruzanov.russianwives.utils.UsersListCallback
import javax.inject.Inject

class SearchInteractor @Inject constructor(private val searchRepository: SearchRepository,
                       private val filterRepository: FilterRepository, private val friendRepository: FriendRepository) {

    fun getFilteredList(usersListCallback: UsersListCallback) {
        searchRepository.searchByListParams(filterRepository.filteredSearchResult, usersListCallback)
    }

    fun setFriendLiked(friendUid: String) {
        friendRepository.setFriendLiked(friendUid)
    }

}
