# A6_At_Your_Service
CS5520: App Design Group Project



“Earthquake Tracker”

Main Activity —> QuakeSearchActivity —> QuakeSearchResults
         launches	       		inputs+loading+network fetch            parses JSON + RecyclerView output
				Passes JSON + metadata via intent 
				extras to QuakeSearchResults



Proposed division of work:  

We need a team name:   edu.northeastern.TeamNameHere?????

Work split - each one of us makes a branch to work on: 

Ruben
Git branch:  core-java
 (Core Java + Manifest)
AndroidManifest.xml
MainActivity.java
QuakeSearchActivity.java
QuakeResultsActivity.java
QuakeService.java (HTTP + JSON parsing)
QuakeParser.java (JSON -> ArrayList<QuakeItem>)
QuakeItem.java (Model)
 QuakeAdapter.java (Adapter)
My “contract” with teammates
I will reference layout IDs (they must match exactly)
I will reference theme/colors/styles/drawables (they must match)


Team Member 2
Git branch:  ui-layout 
(Layouts + Buttons)
UI/Layout
activity_main.xml
activity_quake_search.xml
activity_quake_results.xml
item_quake.xml (RecyclerView row)
Ensure all IDs match what Java expects - see Interface

 Keep all IDs exactly as specified in the interface section below
 Keep layouts responsive in portrait/landscape
 Keep IDs with names (unless we coordinate to change them)


Team Member 3 
Git branch: theme-polish
(Pretty / Theme / Extras)
Design person
themes.xml (+ night/themes.xml if you want)
colors.xml
backgrounds (epicenter waves, gradients)
Optional: nicer icons, shape drawables, button styles, card styles
Optional polish:
a “largest quake” header card on results
empty state illustration
click to open detail bottom sheet or detail activity
Icons, shape drawables, button style overlays, card style overlays, etc.

 Keep resource names stable: 
Theme: @style/Theme.QuakePulse
 Background: @drawable/bg_epicenter
 Colors:  (If you modify, let’s coordinate so we’re all updated on the correct names)
	qp_bg_top, 		qp_bg_mid 
	qp_bg_bottom	qp_card 
	qp_card_stroke	qp_text_primary, 	
	qp_text_secondary	sev_low 		
	sev_med 		sev_high 
		sev_extreme

-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_


Interface
Interface (must match exactly)


A)  Screen 1: MainActivity → activity_main.xml
      	Java uses these IDs:
@+id/btnOpenQuakes
(Optional UI IDs that can exist but aren’t required by Java: tvGroupName, etc.)


B)  Screen 2: QuakeSearchActivity → activity_quake_search.xml
      	Java uses these IDs:

	Magnitude input
@+id/etMinMag
	Time range controls
@+id/rgRange
@+id/rbHour
@+id/rbDay
@+id/rbWeek
Sort controls
@+id/rgSort
@+id/rbSortTime
@+id/rbSortMag
	Action
@+id/btnSearch
	Active loading indicator
@+id/loadingRow
@+id/progress
@+id/tvLoading
	Status / error display
@+id/tvStatus


C) Screen 3: QuakeResultsActivity → activity_quake_results.xml
	Java uses these IDs:
@+id/tvSubHeader
@+id/tvEmpty
@+id/rvQuakes
(Note: tvHeader exists in layout and is fine, but Java doesn’t need to call it.)


D) RecyclerView row: item_quake.xml
	Adapter uses these IDs:
@+id/vAccent
@+id/ivSeverity
@+id/tvMag
@+id/tvTime
@+id/tvPlace
@+id/tvDepth


Updated Intent “data contract” (Search → Results)
	These keys must remain stable because they link the two screens:
	In QuakeSearchActivity.java:
public static final String EXTRA_JSON = "extra_json";
public static final String EXTRA_MIN_MAG = "extra_min_mag";
public static final String EXTRA_RANGE_LABEL = "extra_range_label";
public static final String EXTRA_SORT_MODE = "extra_sort_mode";

What each extra contains
EXTRA_JSON → raw JSON string returned by USGS
EXTRA_MIN_MAG → double
EXTRA_RANGE_LABEL → string like “Past 24 hours”
EXTRA_SORT_MODE → "time" or "mag"
****  This is the “handoff” between Screen 2 and Screen 3 ****
