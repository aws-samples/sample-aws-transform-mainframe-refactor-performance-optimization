import { UtilityComponentsMap, UtilitySubComponentsMap, UtilityModalWrapperMap } from "./utility/";
import { mapModalWrappers } from "./mapModalWrappers";

export const mapSubComponents = {
    ...UtilitySubComponentsMap
};

export const mapComponents = {
    ...UtilityComponentsMap
};

// Populate the shared modal wrapper map defined in a separate file to avoid
// circular dependencies with AbstTermComponent (which also imports it).
Object.assign(mapModalWrappers, UtilityModalWrapperMap);

// Use this map to relate component with a module (for lazy loading)
export const componentModuleMap: {[component: string] : string} = {
}