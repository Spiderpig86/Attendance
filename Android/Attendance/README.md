# Attendance
A better sign in system for clubs.

## Devs
|Name|Position|Github|
|---|---|---|
|Mikey|iOS Dev|[@devhid](https://github.com/devhid)|
|Stanley|Android Dev|[@Spiderpig86](https://github.com/Spiderpig86)|
|Sammi|iOS Dev|[@sammiWL](https://github.com/sammiWL)|
|Johnny|Android Dev|[@jso123450](https://github.com/jso123450)|

## Phase 1 - App Development (Android / iOS)
Developing a working application to capture ID card and extract relevant information from image.

- [ ] Make a working application (plain activity).
	* Create a simple user interface with a button to launch camera view and a textview for viewing extracted text.
- [ ] Integrate text recognition. (Tess/Google Text Recognition API)
	* Use a library to extract information. Android version will use Google Text Recognition API (lower overhead than Tesseract OCR).
	* [Text Recognition API](https://developers.google.com/vision/text-overview)
- [ ] Format results and add corrections to remove invalid chars from name/id
- [ ] Write member data (name, id, email, timestamp) to json file and export it to some location.

## Phase 2 - Online Database/Website
TBA
