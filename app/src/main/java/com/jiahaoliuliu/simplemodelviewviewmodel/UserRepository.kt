package com.jiahaoliuliu.simplemodelviewviewmodel

class UserRepository @Inject constructor (privat val webservice: Webservice, private val userCache: UserCache){

    suspend fun getUser(userId: String): User {
        val cached: User = userCache.get(userId);
        if(cached != null) {
            return cached
        }

        // This implementation is still suboptimal but better than before
        // A complete implementation also handles error cases
        val freshUser = webservice.getUser(userId)
        userCache.put(userId, freshUser)
        return freshUser
    }

}