package com.example.sportshub.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SportResponse(

	@field:SerializedName("teams")
	val teams: List<TeamsItem?>? = null
)

data class TeamsItem(

	@field:SerializedName("strSport")
	val strSport: String = "",

	@field:SerializedName("strBadge")
	val strBadge: String = "",

	@field:SerializedName("strCountry")
	val strCountry: String = "",

	@field:SerializedName("strFanart1")
	val strFanart1: String = "",

	@field:SerializedName("intFormedYear")
	val intFormedYear: String = "",

	@field:SerializedName("idTeam")
	val idTeam: String = "",

	@field:SerializedName("strDescriptionEN")
	val strDescriptionEN: String = "",

	@field:SerializedName("strTeamAlternate")
	val strTeamAlternate: String = "",

	@field:SerializedName("strTeam")
	val strTeam: String = "",
)

