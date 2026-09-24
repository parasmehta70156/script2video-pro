# AI backend

This service is the server-side layer for Paras AI Video Editor.

Required production components:
- Auth/subscription service
- 20-job monthly quota counter
- Object storage for uploaded videos/results
- FFmpeg/video worker
- Scene/silence/highlight analysis
- Caption generation
- Render queue
- Secure AI provider integration

Endpoints are defined in `../AI_EDITOR_ARCHITECTURE.md`.

Do not put API keys or payment secrets in the Android application.
