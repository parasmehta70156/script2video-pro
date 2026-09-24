# Paras AI Video Editor

## Product
Free manual video editing + AI Pro editing.

## Plans
- Free: manual editing, local export.
- Pro: ₹299/month, 20 AI editing jobs/month.

## AI pipeline
1. Upload video
2. Validate subscription and remaining monthly credits
3. Extract media metadata and audio
4. Detect scenes/silences/highlight segments
5. Generate edit decision list
6. Apply cuts, crop to 9:16, transitions, speed effects and color/filter presets
7. Generate captions
8. Optional beat-sync music
9. Render final MP4
10. Return result and decrement one monthly AI credit

## Backend contract
POST /api/ai/edit — multipart video upload + style (reels/shorts/cinematic)
GET /api/ai/jobs/:id — job status
GET /api/ai/credits — remaining monthly credits
POST /api/billing/subscribe — subscription checkout

The Android client must never contain provider API secrets. AI providers/video workers run server-side.

## Important
The AI editor can optimize for short-form/trending-style editing, but cannot guarantee that a video will become viral.
