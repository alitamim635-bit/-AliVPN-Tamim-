# AliVPN

An independent Android VPN app project by Ali Tamim.

## Current status

The initial Android application structure and a Persian, black-and-gold Compose starter screen are committed. GitHub Actions is configured to build a debug APK on pushes to `main`.

**Important:** The current screen is a UI starter only. It does not establish a VPN connection yet. WireGuard/V2Ray engines, server configuration, authentication, subscriptions, and backend services must be implemented and tested before this app can provide VPN service.

## Build

Open the **Actions** tab and select **Android Build**. A successful run uploads an artifact named `AliVPN-debug`.

## Planned work

- Integrate a supported VPN engine and Android VPN service.
- Add secure server/profile provisioning; never commit private keys or credentials.
- Add automatic and manual server selection.
- Add Persian and English localization.
- Add account, free/VIP subscription, and administration services.

## Security

Never commit passwords, private keys, API tokens, server credentials, or personal user data.
