package hos.houns.remote.retrofit

import hos.houns.domain.base.mapper.Mapper

/**
 *
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer data source layers
 *
 * @param [Model] the remote model input type
 * @param [Entity] the entity model output type
 */
interface EntityMapper<Model, Entity> : Mapper<Model, Entity> {

}