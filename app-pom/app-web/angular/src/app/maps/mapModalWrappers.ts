/**
 * Modal wrapper map — maps component names to their modal wrapper components.
 * Separated from mapComponents.ts to avoid circular dependencies with
 * AbstTermComponent (which imports this map). The map is populated at module
 * initialization time by mapComponents.ts via Object.assign.
 */
export const mapModalWrappers: {[key: string]: any} = {};
